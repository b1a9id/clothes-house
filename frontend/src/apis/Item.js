import axios from 'axios';
import * as appConstants from '../constants/AppConstants';

export const fetchItems = () => {
  return axios.get(appConstants.ITEMS_URL);
}
