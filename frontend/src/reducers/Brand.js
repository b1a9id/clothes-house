import * as actionType from '../constants/ActionType';

const initialState = {
  brands: [],
  error: false
}

export default (state = initialState, action) => {
  switch (action.type) {
    case actionType.START_GET_BRANDS:
      return {
        brands: [],
        error: false
      };
    case actionType.GET_BRANDS_RESPONSE:
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, brands: action.payload.response };
    default:
      return state;
  }
}
