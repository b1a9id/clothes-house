import * as actionType from '../constants/ActionType';

export const startGetGenres = () => ({
  type: actionType.START_GET_GENRES
});

export const getGenresResponse = (error, response) => ({
  type: actionType.GET_GENRES_RESPONSE,
  payload: { error, response }
});

export const finishGetGenres = () => ({
  type: actionType.FINISH_GET_GENRES
})
