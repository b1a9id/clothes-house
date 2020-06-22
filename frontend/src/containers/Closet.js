import { connect } from 'react-redux';
import Closet from "../components/Closet";
import * as actions from '../actions/Closet';

const mapStateToProps = (state) => ({
  items: state.Closet.items,
  error: state.Closet.error
})

const mapDispatchToProps = dispatch => ({
  onMount() {
    dispatch(actions.getItems());
  }
});

export default connect(mapStateToProps, mapDispatchToProps)(Closet);
