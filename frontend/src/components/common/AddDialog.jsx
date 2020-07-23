import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import MenuItem from "@material-ui/core/MenuItem";

const brands = [
  {
    value: '1',
    label: 'ETHOSENS'
  },
  {
    value: '2',
    label: 'STOF'
  },
  {
    value: '3',
    label: 'bedsidedrama'
  }
]

const genres = [
  {
    value: '1',
    label: 'T Shirts'
  },
  {
    value: '2',
    label: 'Shirts'
  },
  {
    value: '3',
    label: 'Knit'
  }
]

const colors = [
  {
    value: '1',
    label: 'RED'
  },
  {
    value: '2',
    label: 'YELLOW'
  },
  {
    value: '3',
    label: 'GREEN'
  }
]

export default function AddDialog(props) {
  const [
    brandId,
    setBrandId,
    genreId,
    setGenreId,
    colorId,
    setColorId
  ] = React.useState('');

  const handleBrandChange = (event) => {
    setBrandId(event.target.value);
  }

  const handleGenreChange = (event) => {
    setGenreId(event.target.value);
  }

  const handleColorChange = (event) => {
    setColorId(event.target.value);
  }

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
        <TextField
          id="brand-select"
          select
          label="Brand"
          value={brandId}
          onChange={handleBrandChange}
          fullWidth
        >
          {brands.map((brand) => (
            <MenuItem key={brand.value} value={brand.value}>{brand.label}</MenuItem>
          ))}
        </TextField>
        <TextField
          id="genre-select"
          select
          label="Genre"
          value={genreId}
          onChange={handleGenreChange}
          fullWidth
        >
          {genres.map((genre) => (
            <MenuItem key={genre.value} value={genre.value}>{genre.label}</MenuItem>
          ))}
        </TextField>
        <TextField
          id="color-select"
          select
          label="Color"
          value={colorId}
          onChange={handleColorChange}
          fullWidth
        >
          {colors.map((color) => (
            <MenuItem key={color.value} value={color.value}>{color.label}</MenuItem>
          ))}
        </TextField>
      </DialogContent>
      <DialogActions>
        <Button onClick={props.handleCloseAddDialog} color="primary">
          Save
        </Button>
      </DialogActions>
    </Dialog>
  );
}
