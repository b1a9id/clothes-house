import { call, put, takeEvery} from 'redux-saga/effects';
import { receiveData, finishRequest } from "../actions/Closet";
import * as actionType from '../constants/ActionType';
import * as ItemApi from '../apis/Item';

function* handleRequestItems() {
  try {
    const response = yield call(ItemApi.fetchItems);
    yield put(receiveData(null, response.data));
  } catch (error) {
    yield put(receiveData(error));
  }
  yield put(finishRequest());
}

export default function* rootSaga() {
  yield takeEvery(actionType.ITEMS_START_REQUEST, handleRequestItems);
}
