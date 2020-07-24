import axios from "axios";
import * as appConstants from '../constants/AppConstants';

export const fetchBrands = () => {
  return axios.get(appConstants.BRANDS_URL);
}
