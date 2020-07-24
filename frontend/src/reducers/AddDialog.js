import * as actionType from '../constants/ActionType';

const initialState = {
  brands: [],
  error: false
}

export default (state = initialState, action) => {
  switch (action.type) {
    case actionType.BRANDS_START_REQUEST:
      return {
        brands: [],
        error: false
      };
    case actionType.BRANDS_RECEIVE_DATA:
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, brands: action.payload.response };
    default:
      return state;
  }
}
