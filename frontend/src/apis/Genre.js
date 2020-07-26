import axios from "axios";
import * as appConstants from '../constants/AppConstants';

export const fetchGenres = () => {
  return axios.get(appConstants.GENRES_URL);
}
