import * as actionType from '../constants/ActionType';

const initialState = {
  genres: [],
  error: false
}

export default (state = initialState, action) => {
  switch (action.type) {
    case actionType.START_GET_GENRES:
      return {
        genres: [],
        error: false
      };
    case actionType.GET_GENRES_RESPONSE:
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, genres: action.payload.response };
    default:
      return state;
  }
}
