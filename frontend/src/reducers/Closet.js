import * as actionTypeConstants from '../constants/ActionTypeConstants';

const initialState = {
  items: [],
  error: false
}

export default (state = initialState, action) => {
  switch (action.type) {
    case actionTypeConstants.ITEMS_START_REQUEST:
      return {
        items: [],
        error: false
      };
    case actionTypeConstants.ITEMS_RECEIVE_DATA:
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, items: action.payload.response };
    default:
      return state;
  }
}
