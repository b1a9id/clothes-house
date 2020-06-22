import { applyMiddleware, compose, createStore, combineReducers } from "redux";
import logger from 'redux-logger';
import thunk from 'redux-thunk'
import { routerMiddleware, connectRouter } from "connected-react-router";
import { createBrowserHistory } from "history";
import * as reducers from './reducers';

export const history = createBrowserHistory()

export default function configureStore(preloadedState) {
  return createStore(
    combineReducers({
      ...reducers,
      router: connectRouter(history)
    }),
    preloadedState,
    compose(
      applyMiddleware(
        logger,
        thunk,
        routerMiddleware(history),
      )
    ),
  );
}

