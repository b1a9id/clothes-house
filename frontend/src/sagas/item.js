import { call, put } from "redux-saga/effects";
import * as ItemApi from "../apis/Item";
import {
  getItemsResponse,
  finishGetItems,
  finishPostItem, postItemResponse
} from "../actions/Item";

export function* handleFetchItems() {
  try {
    const response = yield call(ItemApi.fetchItems);
    yield put(getItemsResponse(null, response.data));
  } catch (error) {
    yield put(getItemsResponse(error));
  }
  yield put(finishGetItems());
}

export function* handleCreateItem(action) {
  try {
    const response = yield call(() => ItemApi.createItem(action.payload));
    yield put(postItemResponse(null, response.data));
  } catch (error) {
    yield put(postItemResponse(error));
  }
  yield put(finishPostItem());
}
