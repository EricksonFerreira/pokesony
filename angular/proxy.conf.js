const PROXY_CONFIG = [
  {
    context:['/api'],
    target:'http://localhost:8080',
    secure:false,
    pathRewrite: {'^/api': '123'}
  }
];

module.exports = PROXY_CONFIG
