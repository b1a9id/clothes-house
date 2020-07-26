import axios from "axios";
import * as appConstants from '../constants/AppConstants';

export const fetchColors = () => {
  return axios.get(appConstants.COLORS_URL);
}
