import { call, put } from "redux-saga/effects";
import * as BrandApi from "../apis/Brand";
import { getBrandsResponse, finishGetBrands } from "../actions/Brand";

export function* handleRequestBrands() {
  try {
    const response = yield call(BrandApi.fetchBrands);
    yield put(getBrandsResponse(null, response.data));
  } catch (error) {
    yield put(getBrandsResponse(error));
  }
  yield put(finishGetBrands())
}
