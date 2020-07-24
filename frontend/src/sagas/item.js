import { call, put } from "redux-saga/effects";
import * as ItemApi from "../apis/Item";
import {
  finishRequest as itemsFinishRequest,
  receiveData as itemsReceiveData
} from "../actions/Item";

export function* handleRequestItems() {
  try {
    const response = yield call(ItemApi.fetchItems);
    yield put(itemsReceiveData(null, response.data));
  } catch (error) {
    yield put(itemsReceiveData(error));
  }
  yield put(itemsFinishRequest());
}
