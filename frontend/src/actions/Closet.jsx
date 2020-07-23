import axios from "axios";
import * as appConstants from '../constants/AppConstants';
import * as actionTypeConstants from "../constants/ActionTypeConstants";

const startRequest = () => ({
  type: actionTypeConstants.ITEMS_START_REQUEST
});

const receiveData = (error, response) => ({
  type: actionTypeConstants.ITEMS_RECEIVE_DATA,
  payload: { error, response }
});

const finishRequest = () => ({
  type: actionTypeConstants.ITEMS_FINISH_REQUEST
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
