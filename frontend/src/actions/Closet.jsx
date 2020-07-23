import * as actionType from "../constants/ActionType";

export const startRequest = () => ({
  type: actionType.ITEMS_START_REQUEST
});

export const receiveData = (error, response) => ({
  type: actionType.ITEMS_RECEIVE_DATA,
  payload: { error, response }
});

export const finishRequest = () => ({
  type: actionType.ITEMS_FINISH_REQUEST
});
