/* **********************************************

  File Name: main.js

  Author: zhengdongjian@tju.edu.cn

  Created Time: Tue 19 Apr 2016 09:18:49 PM CST

*********************************************** */
'use strict';

var http = require('https');
var url = require('url');
var jsonfile = require('jsonfile');
var util = require('util');
var fs = require('fs');

var result = 'timeline.json';
var address = 'api.weibo.com';
var accessToken = '2.00yZ2OvC5WzVuD092d91d7e1kpXqUC';
var agent = 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36';
var options = {
	hostname: address,
	port: 443,
	path: '/2/statuses/public_timeline.json?access_token=' + accessToken,
	method: 'GET'
};

var buffer = "";

var req = http.request(options, (res, err) => {
  if (err) {
    console.error('error when request:');
    console.error('  headers: ', res.headers);
    console.error('  tatusCode: ', res.tatusCode);
  }
	
  res.on('data', (dat) => {
    buffer += dat.toString();
	});
  
  res.on('end', () => {
    fs.writeFile(result, JSON.stringify(JSON.parse(buffer)), 'utf8', (e) => {
      if (e) {
        console.log(e);
      }
    });
  });
});

req.end();

req.on('error', (e) => {
	console.error(e);
});

