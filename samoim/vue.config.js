module.exports = {
  transpileDependencies: [
    'vuetify'
  ],

  devServer: {
    proxy: {
      '/api': {
        "target" : 'http://169.56.100.108:32487/',
        //"target" : 'http://localhost:8080/',
        changeOrigin: true,
      }
    }
  }
}
