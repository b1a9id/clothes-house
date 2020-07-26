import * as actionType from '../constants/ActionType';

export const startGetColors = () => ({
  type: actionType.START_GET_COLORS
});

export const getColorsResponse = (error, response) => ({
  type: actionType.GET_COLORS_RESPONSE,
  payload: { error, response }
});

export const finishGetColors = () => ({
  type: actionType.FINISH_GET_COLORS
})
