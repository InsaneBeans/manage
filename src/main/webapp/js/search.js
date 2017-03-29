  
	  var url;
	  var pagesize = 15;  

	  //存放省份的model
	    var provinceModel = Ext.define('provinceModel',{
	    	extend:'Ext.data.Model',
	    	fields: [
	                { name: 'provinceid', type: 'string' },
	  	            { name: 'province', type: 'string' },
	        ]
	    });
	  
	  //存放城市的model
	    var cityModel = Ext.define('cityModel',{
	    	extend:'Ext.data.Model',
	    	fields: [
                    { name: 'provinceid', type: 'string' },
	                { name: 'cityid', type: 'string' },
	  	            { name: 'city', type: 'string' },
	        ]
	    });
	    
	    //存放民族的model
	    var nationModel = Ext.define('nationModel',{
	    	extend:'Ext.data.Model',
	    	fields: [
	                { name: 'u_mzid', type: 'string' },
	  	            { name: 'u_minzu', type: 'string' },
	        ]
	    });

		  //用户数据模型
		  var userModel = Ext.define('userModel',{
			    extend:'Ext.data.Model',
	 	        fields: [
					{ name: 'id',   type: 'string' },
		            { name: 'uname',   type: 'string' },
		            { name: 'uuid',    type: 'string' },
		            { name: 'usex',    type: 'string' },
		            { name: 'udate',   type: 'string' },
		            { name: 'uminzu',  type: 'string' },
		            { name: 'uarea',   type: 'string' },
		            { name: 'uextra',   type: 'string' },
		        ],	
		    });
		     
		    //存放用户的store
			var userStore =	Ext.create('Ext.data.Store',{
				    pageSize:pagesize,
				    model:'userModel',
				    storeId:'userStore',
				    autoLoad : true,  
					remoteSort: true,
					remoteFilter : true,  
					proxy:{
						enablePaging: true,
						type:'ajax',
						url:'/user/list',   
						reader:{
							type:'json',
							root:'content',   
							totalProperty: 'totalElements',
						},
						encodeFilters: function(filters) {
			                return filters[0].value;
			            }
					},
				}); 
	    
	    //民族store
	    var nationStore = Ext.create('Ext.data.Store',{
	        model:'nationModel',
		    storeId:'nationStore',
			remoteSort: true,
			proxy:{
				type:'ajax',
				url:'/user/national',   
				reader:{
					type:'json',
					root:'content',   
					totalProperty: 'totalElements'
				}
			},
	    	
	    });
	    
	    //省份store
	    var provinceStore = Ext.create('Ext.data.Store',{
	        model:'provinceModel',
		    storeId:'provinceStore',
		    autoload:true,
			remoteSort: true,
			proxy:{
				type:'ajax',
				url:'/user/province',   
				reader:{
					type:'json',
					root:'content',   
					totalProperty: 'totalElements'
				}
			},
	    	
	    });
	    
	    //城市store
	    var cityStore = Ext.create('Ext.data.Store',{
	        model:'cityModel',
		    storeId:'cityStore',
			remoteSort: true,
			autoload:false,
			proxy:{
				type:'ajax',
				url:'/user/city',   
				reader:{
					type:'json',
					root:'content',   
					totalProperty: 'totalElements'
				},
			},
	    });

        //顶部搜索菜单
	    var searchform = Ext.create('Ext.form.Panel',{
	    	margin:'3px,3px,0,0',
	    	width:992,
	    	height:60,
	    	border:false,
	    	layout:'column',
	    	id:'searchform',
	    	fieldDefaults: {
	    	        labelWidth: 45,
	    	        labelAlign: "left",
	    	    },
	    	items : [{
	    		   columnWidth:.3,
	    		   xtype:'fieldset',
	    		   layout:'form',
	    		   border:false,
	    		   items:[{
	    		   xtype : 'textfield',
		    	   margin: '3px 5px 0 0',
		           fieldLabel : '姓名',
		           name : 'uname',
		           allowBlank : true,
		           emptyText : "姓名",
		       }, {
		    	   xtype : 'textfield',
		    	   margin : '3px 5px 0 0',
		           fieldLabel : '身份证',
		           name : 'uuid',
		           allowBlank : true,
		           emptyText : "身份证",
		       }]
	    	   }, 
		       {   margin : '0 5px 0 0',
	    		   columnWidth:.3,
		    	   xtype: "fieldset",
		           layout: "form",
		           border:false,
		    	   items:[{
		    		      margin : '3px 0 0 0',
			              xtype : 'combo',
			              fieldLabel : '性别',
			              emptyText : '选择性别',
			              store : new Ext.data.SimpleStore({
								fields : [ 'value', 'text' ],
								data : [ [ 'male', '男' ], [ 'female', '女' ] ]
						  }),
			              displayField : 'text',
			              valueField : 'text',
			              name : 'usex',
			              editable:false,
			              allowBlank : true
			     	    },{
		                    xtype : 'datefield',
							fieldLabel : '生日',
							emptyText : '选择生日',
							format: 'Y-m-d',
							name : 'udate',
							editable:false,
							allowBlank : true
		   			    }
			     	    ]
		          },{
		           columnWidth:.3,
		    	   xtype: "fieldset",
		           layout: "form",
		           border:false,
		    	   margin : '0 5px 0 0',
		           items:[{
		        	       margin : '3px 0 0 0',
				           xtype : 'combo',
				           store:nationStore,
				           fieldLabel : '民族',
				           emptyText : '选择民族',
				           name : 'uminzu',
				           editable:false,
				           allowBlank : true,
				           displayField: 'u_minzu',
				           valueField: 'u_minzu',
				       }, {
				    	   border:false,
					       xtype : 'combo',
					       store:provinceStore,
						   labelWidth:45,
						   fieldLabel : '籍贯',
					       blankText : '籍贯不能为空',
					       emptyText : '选择籍贯',
					       name:'uarea',
					       editable:false,
					       allowBlank : true,
				           displayField: 'province',
				           valueField: 'province',
					  }]
		   		    },{
				       columnWidth:.1,
			    	   xtype: "fieldset",
			           layout: "form",
			           border:false,
			           items:[{
				           margin : '3px 5px 0 0',
				    	   xtype:'button',
				    	   width:65,
				    	   text : '查询',
				    	   iconCls:'search',
					       type : 'submit',
					       handler : function() {
							    var sformvalue = searchform.getForm();
							    var province = sformvalue.findField('uarea').getValue();  
							    console.log(province);
							    userStore.proxy.url='/user/search';
								userStore.load({ params: { user: sformvalue} });
								Ext.getCmp('searchform').getForm().reset();
					            }
					       },{
				    	   margin : '3px 5px 0 0',
				    	   width:65,
				    	   iconCls:'clear',
				    	   xtype:'button',
				    	   align:'left',
				    	   text:'清空',
				           handler : function() {
				        	    Ext.getCmp('searchform').getForm().reset();
				           }
		      	  }]
		   		  }
		   		    
		   		    ]
});	    