module.exports = {
  transpileDependencies: [
    'vuetify'
  ],

  devServer: {
    proxy: {
      '/api': {
        "target" : 'http://169.56.100.108:32487/samoim/',
        "pathRewrite": {'^/api': ''},
      }
    }
  }
}
