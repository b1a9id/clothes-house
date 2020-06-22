import axios from "axios";
import * as appConstants from '../constants/AppConstants'

const startRequest = () => ({
  type: 'START_REQUEST'
});

const receiveData = (error, response) => ({
  type: 'RECEIVE_DATA',
  payload: { error, response }
});

const finishRequest = () => ({
  type: 'FINISH_REQUEST'
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
