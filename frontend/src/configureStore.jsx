import { applyMiddleware, compose, createStore } from "redux";
import logger from 'redux-logger';
import thunk from 'redux-thunk'
import { routerMiddleware } from "connected-react-router";
import { createBrowserHistory } from "history";
import createRootReducer from "./reducers";

export const history = createBrowserHistory()

export default function configureStore(preloadedState) {
  return createStore(
    createRootReducer(history),
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

