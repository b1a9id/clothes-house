import { applyMiddleware, compose, createStore, combineReducers } from "redux";
import logger from 'redux-logger';
import thunk from 'redux-thunk'
import { routerMiddleware, connectRouter } from "connected-react-router";
import createSagaMiddleware from 'redux-saga';
import { createBrowserHistory } from "history";
import * as reducers from './reducers';
import rootSaga from './sagas';

export const history = createBrowserHistory()

export default function configureStore(preloadedState) {
  const sagaMiddleware = createSagaMiddleware();
  const store = createStore(
    combineReducers({
      ...reducers,
      router: connectRouter(history)
    }),
    preloadedState,
    compose(
      applyMiddleware(
        sagaMiddleware,
        logger,
        thunk,
        routerMiddleware(history),
      )
    ),
  );
  sagaMiddleware.run(rootSaga);
  return store;
}

