<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% if(session.getAttribute("adminid")==null||session.getAttribute("adminid")=="") { --%>
<!--  	 response.sendRedirect("/"); -->
<!--     } -->
<!--  %>  -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all.css"></link>
<link rel="stylesheet" type="text/css" href="css/list.css"></link>
<link rel="stylesheet" type="text/css" href="css/index.css"></link>
<script type="text/javascript" src="extjs/ext-all.js"></script>
<script type="text/javascript" src="extjs/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/help.js"></script>
<script type="text/javascript" src="js/msgTip.js"></script>
<script type="text/javascript" src="js/upload.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="extjs/examples/ux/form/SearchField.js"></script>
<script type="text/javascript" src="extjs/examples/ux/form/MultiSelect.js"></script>
<script type="text/javascript" src="extjs/examples/ux/ProgressBarPager.js"></script>
<title>用户管理系统</title>
</head>
<body>
	<div class="dive">
	<span>欢迎管理员：</span>
	<span ><%=session.getAttribute("adminid")%></span>
	<span><a href="logout.jsp" class="aa">&nbsp;&nbsp;&nbsp;注销</a></span>
	</div>
    <div class="searchdiv" id="searchdiv"></div>
	<script type="text/javascript">
Ext.onReady(function() {
	  Ext.tip.QuickTipManager.init();
	  
	    function onStoreSizeChange() {
	        grid.down('#status').update({count: store.getTotalCount()});
	    }
	    
	    //顶部按钮集
	    var buttonbar = Ext.create('Ext.container.Container',{
				width:700,
				border:false,
				items : [{
					margin:'3px,5px,3px,5px',
	            	xtype:'button',
					text : '添加用户',
					iconCls :'add',
					align:'left',
					handler : function() {
						Ext.getCmp('userform').getForm().reset(); 
						url='/user/add';
						userwin.show();
						
						}
				}, {
					margin:'3px,5px,3px,5px',
					xtype:'button',
					text : '删除用户',
					iconCls :'delete',
					align:'left',
					handler : function() {
						var count = grid.getSelectionModel().getCount(); 
						if(count<=0){
							MsgTip.msg('提示!','请选择要删除的用户',true);
						}else{
						    Ext.Msg.confirm('确认删除','你确定要删除选中的用户吗？',function(button){
						    if(button=="yes"){                            
			                       deleteUser();
			                }
						    });
						}
						
					}
				}, {
					margin:'3px,5px,3px,5px',
					xtype:'button',
					text:'批量导入',
					region:'right',
					iconCls :'upload',
					handler:function(){
					   upwin.show();
					}
				}, {
					margin:'3px,5px,3px,5px',
					xtype:'button',
					text:'帮助',
					region:'right',
					iconCls :'help',
					handler:function(){
					helpWin.show();
					}
				}]	    	
	    });
	    
        //创建多选框
		var checkBox = Ext.create('Ext.selection.CheckboxModel');  

        //显示用户列表表格
		var grid = Ext.create('Ext.grid.Panel', {
			
				hideCollapseTool : false,
				store :  Ext.data.StoreManager.lookup('userStore'),
				width : 1000,
				height:500,
				renderTo : 'grid-example', 
				viewConfig: {
                    autoFill: true
                },
				selModel:checkBox,  
                disableSelection: false,
				selType: 'rowmodel',
				title : '用户列表',
				columnLines : true,
				listeners : {
					itemdblclick : function(view, record, item, index, e, eOpts) {
						url='/user/modify';
						var snode = grid.getSelectionModel().getSelection(); 
						if (snode == undefined || snode.length <= 0) {
						   return;
						}
						snode = snode[0].data;
						var formvalues = userform.getForm();
						var areavalues = record.get('uarea');
						var substr = areavalues.split('-',2);
					    formvalues.findField('uuid').setValue(record.get('uuid'));
					    formvalues.findField('uname').setValue(record.get('uname'));
					    formvalues.findField('usex').setValue(record.get('usex'));
					    formvalues.findField('uminzu').setValue(record.get('uminzu'));
					    formvalues.findField('udate').setValue(record.get('udate'));
					    formvalues.findField('uextra').setValue(record.get('uextra'));
					    formvalues.findField('uarea').setValue(substr[0]);
					    formvalues.findField('ucity').setValue(substr[1]);
					    userwin.show();	
						},
				},
				columns : [
				  {header:'行号',width:40, align : 'center',xtype: 'rownumberer'},
				  {header : '姓名',flex : 1,align : 'center', dataIndex : 'uname'},
				  {header : '性别',flex : 1,align : 'center', dataIndex : 'usex'}, 
				  {header : '身份证',flex : 1,align : 'center',dataIndex : 'uuid'}, 
				  {header: '生日',flex : 1, align : 'center', dataIndex : 'udate'},
				  {header : '民族',flex : 1,align : 'center', dataIndex : 'uminzu'}, 
				  {header : '籍贯',flex : 1,align : 'center', dataIndex : 'uarea'},
				  {header : '备注',flex : 1,align : 'center', dataIndex : 'uextra'},
				  ],
			dockedItems : [{xtype : 'form', dock : 'top', items : [searchform]},
			               {xtype : 'form', dock : 'top', items : [buttonbar] }, 
			               {xtype : 'pagingtoolbar',pageSize:pagesize,store : userStore, 
				            dock : 'bottom',displayInfo : true,plugins: Ext.create('Ext.ux.ProgressBarPager', {}),
	                       }
			              ]
			});
        
		//用户表单
		var userform = Ext.create('Ext.form.Panel',{
		            id:'userform',
				    border:false,	
				    buttonAlign:'center',
				    defaults:{labelWidth:60},
			        items:[{
			        anchor:'76%',
			        xtype : 'textfield',
				    fieldLabel : '姓名',
				    blankText : '姓名不能为空',
				    emptyText : '姓名',
				    name : 'uname',
			 	    allowBlank : false,
				 },{
					xtype : 'textfield',
					anchor:'76%',
					fieldLabel : '身份证',
					blankText : '身份证不能为空',
					emptyText : '身份证',
 				    regex:/(^\d{15}$)|(^\d{18}$)|(^\d{17}([0-9]|x|X)$)/, 
					regexText:'身份证格式不正确',
					name : 'uuid',
					allowBlank : false,
				}, {
					xtype : 'combo',
					anchor:'76%',
					blankText : '您还没选择性别',
					emptyText:'选择性别',
					fieldLabel : '性别',
					name : 'usex',
					store : new Ext.data.SimpleStore({
						fields : [ 'value', 'text' ],
						data : [ [ 'male', '男' ], [ 'female', '女' ] ]
					}),
					displayField : 'text',
					valueField : 'text',
					mode : 'local',
					editable:false,
					allowBlank : false,
				}, {
					fieldLabel : '生日',
					anchor:'76%',
					blankText : '请选择生日',
					name : 'udate', 
					xtype : 'datefield',
					format: 'Y-m-d',
					emptyText : '选择生日',
					tooltip : '选择生日',
					editable:false,
					allowBlank : false,
				}, {
					xtype : 'combo',
					fieldLabel : '民族',
					anchor:'76%',
					blankText : '民族不能为空',
		            store:nationStore,
		            emptyText : '选择民族',
		            name : 'unation',
		            editable:false,
		            allowBlank : true,
		            displayField: 'minzuName',
		           valueField: 'minzuName',
				}, {
					border:false,
					anchor:'94%',
					layout:'column',
					items:[{
					      xtype : 'combo',
					      store:provinceStore,
					      layout:'form',
						  labelWidth:60,
						  fieldLabel : '籍贯',
					      columnWidth:.6,
					      blankText : '省份不能为空',
					      emptyText : '选择省份',
					      name:'uaddress',
					      id:'uaddress',
					      editable:false,
					      allowBlank : false,
					      valueField : 'provName',
					      displayField:'provName',
				          listeners:{
				    		   select:function(combo,record,index){
				    			   try{
				    				   var ucity = Ext.getCmp('ucity');
					    			   ucity.clearValue();
					    			   ucity.store.load({
					    						params:{
					    							provincename:combo.getValue(),
					    						}
					    					});

				    			   }catch(ex){
				    				   alert("数据加载失败！");
				    			   }
				    		   }
				         },
				      },{
				  	    xtype : 'combo',
				  	    layout:'form',
					    store : cityStore,
					    columnWidth :.4,
					    blankText : '城市不能为空',
					    emptyText : '选择城市',
					    name : 'ucity',
					    id :'ucity',
					    selectOnFocus:true,
					    editable : false,
				    	allowBlank : false,
				    	valueField:'cityName',
					    displayField:'cityName',
				}]
				}, {
		            xtype: 'textarea',
		            anchor:'94%',
		            laytou:'form',
		            fieldLabel: '备注',
		            emptyText : '添加个人备注',
		            hideLabel: false,
		            name: 'uextra',
		            style: 'margin:0',
		            allowBlank:true,
		        }],
			});

			//修改用户window
			var userwin = Ext.create('Ext.window.Window',{
					
					title:'修改用户',
					height:370,
					width:350,
					align:'center',
					autoDestroy:false,
					layout:'form',
					closeAction:'hide',
					bodyStyle:"padding:5px 5px 0",
					plain:true,
					modal:true,
					resizable:false,
					items:[userform],
					buttons:[{
						text : '保存',
						formBind: true,
						handler : function() {  					    
						    var formvalues = userform.getForm();
						    var city = formvalues.findField('ucity').getValue();
						    var province = formvalues.findField('uarea').getValue();  
						    var areavalue = {
						    		uarea:province+'-'+city,
						    }
						    formvalues.setValues(areavalue);
				            if (formvalues.isValid()){
				                formvalues.submit({
					                url:url,
							        waitTitle:'请稍等',
							        waitMsg:'正在保存 ...',
				                    success: function(formvalues,action) {
				                    		 Ext.Msg.alert('成功', action.result.msg);
			        		                 userStore.load();
			        		                 userwin.hide();	
				                    	},
				                    failure: function(formvalues,action) {
				                             Ext.Msg.alert('失败', action.result.sucess + " " + 
				                            		 action.result.failure + " " + action.result.msg);
				                    },
				                    params:{user:formvalues}
				                });
				            } else {
						      MsgTip.msg('错误','还有未填写的选项',true);
						  	}
						}
					}, {
						text : '重置',
						handler : function() {  					
						          Ext.getCmp('userform').getForm().reset();
						          }
					}, {
						text : '关闭',
						handler : function() {  
							 userwin.hide();
						}
					}]
			});
		
		//删除用户方法
		function deleteUser(){
				    var selected = grid.getSelectionModel().getSelection();
	                var array = new Array(selected.length);         
	                for(var i=0;i<selected.length;i++){
	                	array[i] = selected[i].get('uuid');
	                }  
					Ext.Ajax.request({
				         url: '/user/delete',
				         waitTitle:'请稍等',
				         waitMsg:'正在删除',
				         success: function (response) {
				                 Ext.Msg.alert('提示', '删除成功');
			 				     var totalcount = userStore.getTotalCount();
			 				     var lastpage = parseInt(totalcount/pagesize);
			 				     if(selected.length == totalcount%pagesize){
				                         userStore.loadPage(lastpage);
			 				     } else {
			 				    	     userStore.load();
			 				     }
				         },
				         failure: function (response) {
				                 Ext.Msg.alert('提示', '删除失败');
				         },
				         params: {uuid:array} 
				     });
		}
 		});
	</script>
<div id="grid-example" align="center"></div>
</body>
</html>