import { call, put } from 'redux-saga/effects';
import * as GenreApi from '../apis/Genre';
import { getGenresResponse, finishGetGenres } from '../actions/Genre';

export function* handleFetchGenres() {
  try {
    const response = yield call(GenreApi.fetchGenres);
    yield put(getGenresResponse(null, response.data));
  } catch (error) {
    yield put(getGenresResponse(error));
  }
  yield put(finishGetGenres());
}
