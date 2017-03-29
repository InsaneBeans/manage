var upform = Ext.create('Ext.form.Panel', {
		
			id:'upform',
			width: 350,
		    border:false,
		    buttonAlign:'center',
		    items: [{
		        xtype: 'filefield',
		        name: 'fileupload',
		        id:'fileupload',
		        fieldLabel: '选择文件',
		        labelWidth: 65,
		        msgTarget: 'side',
		        emptyText:'选择Csv或Excel文件上传',
		        allowBlank: false,
		        anchor: '93%',
		        buttonText: '浏览',
		    }],
		    buttons: [{
		        text: '上传',
		        handler: function() {
		            var form = this.up('form').getForm();
		            var pathname = Ext.getCmp('fileupload').getValue();
		            var filename = pathname.split('.');
		            var dotname =  filename[filename.length-1];
		            if(dotname!="xls"&&dotname!="csv"&&dotname!="xlsx"){
		            	Ext.Msg.alert('提示','请上传CSV或者Excel文件！');
		            	return false;
		            }
		            if(form.isValid()){
		                form.submit({
		                    url: '/user/upload',
		                    waitMsg: '正在导入...',
		                    success: function(fp, o) {
		                        Ext.Msg.alert('成功', o.result.file);
		                    },
		                    failure:function(){
		                	    Ext.Msg.alert('错误');
		                    }
		                });
		            } else {
		            	Ext.Msg.alert('提示','请先选择一个文件!');
		            }
		        }
		   
		    }, {
		    	text:'关闭',
		    	handler:function(){
		    		upwin.hide();
		    	}
		    }]
});

var upwin = Ext.create('Ext.window.Window',{
	
			title:'文件上传',
			height:140,
			width:360,
			bodyStyle:"padding:5px 5px 0",
			align:'center',
			autoDestroy:false,
		    plain:true,
			modal:true,
			layout:'form',
			closeAction:'hide',
			resizable:true,
			items:[upform]
   });
