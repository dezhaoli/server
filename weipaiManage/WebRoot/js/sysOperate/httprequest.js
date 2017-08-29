/***
 * http请求
 * 
 */

/**
 * http 请求函数
 * @param {Object} url 路径
 * @param {Object} data 数据
 * @param {Object} successCallback 成功回调
 * @param {Object} failCallBack 失败回调
 */
function httpRequest(url,data,successCallback,failCallBack){
	$.ajax({ url: "test.html", context: document.body, success: function(){
    	 $(this).addClass("done");
	}});
}

