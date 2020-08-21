import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createStore } from 'redux';
<<<<<<< HEAD
import thunk from 'redux-thunk';
import { createLogger } from 'redux-logger'
import { applyMiddleware } from 'redux';
import { compose } from 'redux';

import './index.css';
import App from './App';
=======
>>>>>>> e00fc49... Having problem setting mystate in Reducer.js
import thunk from 'redux-thunk';
import { createLogger } from 'redux-logger'
import { applyMiddleware } from 'redux';
import { compose } from 'redux';

import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import reducer from './store/reducer';

<<<<<<< HEAD
<<<<<<< HEAD
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const middleware = [thunk]
if (process.env.NODE_ENV !== 'production') {
  middleware.push(createLogger())
}

const store = createStore(
  reducer,
  composeEnhancers(applyMiddleware(...middleware))
)

const app = (
  <Provider store={store}>
    <BrowserRouter>
      <App dispatch={store.dispatch} />
    </BrowserRouter>
  </Provider>
=======
// const store = createStore(reducer);
=======
const composeEnhancers  = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
>>>>>>> e00fc49... Having problem setting mystate in Reducer.js

const middleware = [ thunk ]
if (process.env.NODE_ENV !== 'production') {
    middleware.push(createLogger())
   }

  const store = createStore(
    reducer,
    composeEnhancers(applyMiddleware(...middleware))
  )

const app = (
    <Provider store={store}>
        <BrowserRouter>
            <App dispatch={store.dispatch}/>
        </BrowserRouter>
    </Provider>
>>>>>>> 300cfc7... Added Redux Dispatch
);

ReactDOM.render(app, document.getElementById('root'));
registerServiceWorker();
