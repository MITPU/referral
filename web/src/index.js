import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createStore } from 'redux';

import './index.css';
import App from './App';
import thunk from 'redux-thunk';
import { createLogger } from 'redux-logger'
import { applyMiddleware } from 'redux';
import registerServiceWorker from './registerServiceWorker';
import reducer from './store/reducer';

// const store = createStore(reducer);

const middleware = [ thunk ]
if (process.env.NODE_ENV !== 'production') {
    middleware.push(createLogger())
   }
  
  const store = createStore(
    reducer,
    applyMiddleware(...middleware)
  )


const app = (
    <Provider store={store}>
        <BrowserRouter>
            <App dispatch={store.dispatch}/>
        </BrowserRouter>
    </Provider>
);

ReactDOM.render( app, document.getElementById('root'));
registerServiceWorker();
