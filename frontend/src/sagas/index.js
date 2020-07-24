import { call, put, takeEvery} from 'redux-saga/effects';
import {
  receiveData as itemsReceiveData,
  finishRequest as itemsFinishRequest
} from "../actions/Item";
import {
  receiveData as brandsReceiveData,
  finishRequest as brandsFinishRequest
} from "../actions/Brand";
import * as actionType from '../constants/ActionType';
import * as ItemApi from '../apis/Item';
import * as BrandApi from "../apis/Brand";

function* handleRequestItems() {
  try {
    const response = yield call(ItemApi.fetchItems);
    yield put(itemsReceiveData(null, response.data));
  } catch (error) {
    yield put(itemsReceiveData(error));
  }
  yield put(itemsFinishRequest());
}

function* handleRequestBrands() {
  try {
    const response = yield call(BrandApi.fetchBrands);
    yield put(brandsReceiveData(null, response.data));
  } catch (error) {
    yield put(brandsReceiveData(error));
  }
  yield put(brandsFinishRequest())
}

export default function* rootSaga() {
  yield takeEvery(actionType.ITEMS_START_REQUEST, handleRequestItems);
  yield takeEvery(actionType.BRANDS_START_REQUEST, handleRequestBrands);
}
