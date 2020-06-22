const initialState = {
  items: [],
  error: false
}

export default (state = initialState, action) => {
  switch (action.type) {
    case 'START_REQUEST':
      return {
        items: [],
        error: false
      };
    case 'RECEIVE_DATA':
      return action.payload.error ?
        { ...state, error: true } :
        { ...state, items: action.payload.response };
    default:
      return state;
  }
}
