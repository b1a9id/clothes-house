import { connect } from 'react-redux';
import Closet from "../components/Closet";
import * as actions from '../actions/Closet';

const mapStateToProps = () => ({})

const mapDispatchToProps = dispatch => ({
  onMount() {
    dispatch(actions.getItems());
  }
});

export default connect(mapStateToProps, mapDispatchToProps)(Closet);
