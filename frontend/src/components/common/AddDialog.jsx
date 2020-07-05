import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";

export default function AddDialog(props) {
  return (
    <Dialog open={props.open} onClose={props.handleCloseAddDialog} aria-labelledby="form-dialog-title">
      <DialogTitle id="form-dialog-title">Add Item</DialogTitle>
      <DialogContent>
        <TextField
          autoFocus
          required
          margin="dense"
          id="imageUrl"
          label="Image URL"
          type="url"
          fullWidth
        />
      </DialogContent>
      <DialogActions>
        <Button onClick={props.handleCloseAddDialog} color="primary">
          Save
        </Button>
      </DialogActions>
    </Dialog>
  );
}
