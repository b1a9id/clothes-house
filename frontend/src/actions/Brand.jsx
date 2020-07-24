import * as actionType from '../constants/ActionType';

export const startRequest = () => ({
  type: actionType.BRANDS_START_REQUEST
});

export const receiveData = (error, response) => ({
  type: actionType.BRANDS_RECEIVE_DATA,
  payload: { error, response }
});

export const finishRequest = () => ({
  type: actionType.BRANDS_FINISH_REQUEST
})
