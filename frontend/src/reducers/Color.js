import * as actionType from '../constants/ActionType';

const initialState = {
  colors: [],
  error: false
}

export default (state = initialState, action) => {
  switch (action.type) {
    case actionType.START_GET_COLORS:
      return {
        colors: [],
        error: false
      };
    case actionType.GET_COLORS_RESPONSE:
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, colors: action.payload.response };
    default:
      return state;
  }
}
