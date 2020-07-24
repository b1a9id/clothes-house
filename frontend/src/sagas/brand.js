import { call, put } from "redux-saga/effects";
import * as BrandApi from "../apis/Brand";
import {
  finishRequest as brandsFinishRequest,
  receiveData as brandsReceiveData
} from "../actions/Brand";

export function* handleRequestBrands() {
  try {
    const response = yield call(BrandApi.fetchBrands);
    yield put(brandsReceiveData(null, response.data));
  } catch (error) {
    yield put(brandsReceiveData(error));
  }
  yield put(brandsFinishRequest())
}
