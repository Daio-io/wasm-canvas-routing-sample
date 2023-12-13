# Sample WASM Routing Project

This project is deployed here: https://wasm-routing-sample.pages.dev/ to play around with.

Basic example of routing using:

https://github.com/hfhbd/routing-compose

For this sample to work I needed to create a `webpack.config.d/devServerConfig.js` to include

```
config.devServer = {
  ...config.devServer, // Merge with other devServer settings
  "historyApiFallback": true
};
```

As explained [here](https://github.com/hfhbd/routing-compose?tab=readme-ov-file#development-usage)

### Browser
Run the browser application: `./gradlew :composeApp:jsBrowserDevelopmentRun`
