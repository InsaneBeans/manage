var helpWin = Ext.create('Ext.window.Window',{
	 title: '用户帮助',
	 header: {
         titlePosition: 2,
         titleAlign: 'center'
     },
	 height: 250,
	 width: 400,
 	 layout: 'form',
     plain:true,
	 modal:true,
     closeAction: 'hide',
     items: [{
         region:'center',
         xtype: 'tabpanel',
         items: [{
         rtl: false,
         title: '用户操作说明',
         html: '<p>增、删、查、改用户操作：</p><pre style="margin-left:20px,font-size:16px">1.添加用户--点击添加用户按钮 \n2.删除用户--左侧多选框选中需要删除的用户，点击删除按钮   \n3.修改用户--在表格中双击想要修改的用户信息行\n4.查找用户--在表格上方搜索框中输入搜索内容，点击搜索 </pre>'
     }, {
         title: '管理员说明',
         html: '<p>需要管理员帐号请联系：管理员：huhong@bonc.com.cn<pre>\n@BONC</pre></p>'
     }]
     }]
});