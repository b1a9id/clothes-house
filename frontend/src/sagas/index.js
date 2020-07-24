import { takeEvery } from 'redux-saga/effects';
import * as actionType from '../constants/ActionType';
import * as itemRequest from './item';
import * as brandRequest from './brand';

export default function* rootSaga() {
  yield takeEvery(actionType.ITEMS_START_REQUEST, itemRequest.handleRequestItems);
  yield takeEvery(actionType.BRANDS_START_REQUEST, brandRequest.handleRequestBrands);
}
