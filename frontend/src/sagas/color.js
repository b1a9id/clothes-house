import { call, put } from 'redux-saga/effects';
import * as ColorApi from '../apis/Color';
import { getColorsResponse, finishGetColors } from '../actions/Color';

export function* handleFetchColors() {
  try {
    const response = yield call(ColorApi.fetchColors);
    yield put(getColorsResponse(null, response.data));
  } catch (error) {
    yield put(getColorsResponse(error));
  }
  yield put(finishGetColors());
}
