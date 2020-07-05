import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";

export default function AddDialog(props) {
  return (
    <Dialog open={props.open} onClose={props.handleCloseAddDialog} aria-labelledby="form-dialog-title">
      <DialogTitle id="form-dialog-title">Add Item</DialogTitle>
      <DialogContent>
        <DialogContentText>
          TEST
        </DialogContentText>
        <TextField
          autoFocus
          margin="dense"
          id="name"
          label="Email Address"
          type="email"
          fullWidth
        />
      </DialogContent>
      <DialogActions>
        <Button onClick={props.handleCloseAddDialog} color="primary">
          Subscribe
        </Button>
      </DialogActions>
    </Dialog>
  );
}
