import axios from "axios";
import * as appConstants from '../constants/AppConstants';
import * as actionType from "../constants/ActionType";

const startRequest = () => ({
  type: actionType.ITEMS_START_REQUEST
});

const receiveData = (error, response) => ({
  type: actionType.ITEMS_RECEIVE_DATA,
  payload: { error, response }
});

const finishRequest = () => ({
  type: actionType.ITEMS_FINISH_REQUEST
});

export const getItems = () => {
  return async dispatch => {
    dispatch(startRequest());

    try {
      const response = await axios.get(appConstants.ITEMS_URL);
      const data = response.data;
      dispatch(receiveData(null, data));
    } catch (e) {
      dispatch(receiveData(e));
    }
    dispatch(finishRequest());
  }
}
