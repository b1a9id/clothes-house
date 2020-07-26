import * as actionType from '../constants/ActionType';

const initialState = {
  items: [],
  error: false
};

export default (state = initialState, action) => {
  switch (action.type) {
    case actionType.START_GET_ITEMS:
    case actionType.START_POST_ITEM:
      return state;
    case actionType.GET_ITEMS_RESPONSE:
    case actionType.POST_ITEM_RESPONSE:
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, items: action.payload.response };
    default:
      return state;
  }
}
