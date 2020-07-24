import { call, put, takeEvery} from 'redux-saga/effects';
import { receiveData as itemReceiveData, finishRequest as itemFinishRequest } from "../actions/Item";
import * as actionType from '../constants/ActionType';
import * as ItemApi from '../apis/Item';

function* handleRequestItems() {
  try {
    const response = yield call(ItemApi.fetchItems);
    yield put(itemReceiveData(null, response.data));
  } catch (error) {
    yield put(itemReceiveData(error));
  }
  yield put(itemFinishRequest());
}

export default function* rootSaga() {
  yield takeEvery(actionType.ITEMS_START_REQUEST, handleRequestItems);
}
