import * as actionType from '../constants/ActionType';

const initialState = {
  items: [],
  error: false
}

export default (state = initialState, action) => {
  switch (action.type) {
    case actionType.ITEMS_START_REQUEST:
      return {
        items: [],
        error: false
      };
    case actionType.ITEMS_RECEIVE_DATA:
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, items: action.payload.response };
    default:
      return state;
  }
}
