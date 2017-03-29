	MsgTip = function(){  
	    var msgCt;
	    function createBox(t, s){
	        return ['<div class="msg">',
	                '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>',
	                '<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc" style="font-size=12px;"><h3>', t, '</h3>', s, '</div></div></div>',
	                '<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>',
	                '</div>'].join('');
	    }
	    return {
	        msg : function(title, message,autoHide,pauseTime){
	            if(!msgCt){
	                msgCt = Ext.DomHelper.insertFirst(document.body, {
	                	id:'msg-div22',
	                	style:'background:#dcdcdc;position:absolute;width:200px;margin:0 auto;z-index:20000;'}, 
	                	true);
	            }
	            msgCt.alignTo(document, 't-t');
	            var m = Ext.DomHelper.append(msgCt, {html:createBox(title, message)}, true);
	            m.slideIn('t');
	            if(!Ext.isEmpty(autoHide)&&autoHide==true){
	               if(Ext.isEmpty(pauseTime)){
	                  pauseTime=1000;
	               }
	               m.pause(pauseTime).ghost("tr", {remove:true});
	            }
	        },
	        hide:function(v){
	         var msg=Ext.get(v.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement);
	         msg.ghost("tr", {remove:true});
	        }
	    };
	}();