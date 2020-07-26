import { takeEvery } from 'redux-saga/effects';
import * as actionType from '../constants/ActionType';
import * as itemRequest from './item';
import * as brandRequest from './brand';
import * as colorRequest from './color';

export default function* rootSaga() {
  yield takeEvery(actionType.START_GET_ITEMS, itemRequest.handleFetchItems);
  yield takeEvery(actionType.START_POST_ITEM, itemRequest.handleCreateItem);
  yield takeEvery(actionType.START_GET_BRANDS, brandRequest.handleFetchBrands);
  yield takeEvery(actionType.START_GET_COLORS, colorRequest.handleFetchColors);
}
