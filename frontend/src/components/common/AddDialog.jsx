import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import MenuItem from "@material-ui/core/MenuItem";

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

export default function AddDialog(props) {
  const [imageUrl, setImageUrl] = React.useState('');
  const [brandId, setBrandId] = React.useState(null);
  const [genreId, setGenreId] = React.useState(null);
  const [colorId, setColorId] = React.useState(null);

  const handleImageUrlChange = (event) => {
    setImageUrl(event.target.value);
  }

  const handleBrandChange = (event) => {
    setBrandId(event.target.value);
  }

  const handleGenreChange = (event) => {
    setGenreId(event.target.value);
  }

  const handleColorChange = (event) => {
    setColorId(event.target.value);
  }

  const postForm = () => {
    const request = { imageUrl, brandId, genreId, colorId }
    props.postItemDispatch(request)
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
          onInput={handleImageUrlChange}
          value={imageUrl}
          fullWidth
        />
        <TextField
          id="brand-select"
          select
          label="Brand"
          type="number"
          value={brandId}
          onChange={handleBrandChange}
          fullWidth
        >
          {props.brands.map((brand) => (
            <MenuItem key={brand.id} value={brand.id}>{brand.name}</MenuItem>
          ))}
        </TextField>
        <TextField
          id="genre-select"
          select
          label="Genre"
          type="number"
          value={genreId}
          onChange={handleGenreChange}
          fullWidth
        >
          {props.genres.map((genre) => (
            <MenuItem key={genre.id} value={genre.id}>{genre.name}</MenuItem>
          ))}
        </TextField>
        <TextField
          id="color-select"
          select
          label="Color"
          type="number"
          value={colorId}
          onChange={handleColorChange}
          fullWidth
        >
          {props.colors.map((color) => (
            <MenuItem key={color.id} value={color.id}>{color.name}</MenuItem>
          ))}
        </TextField>
      </DialogContent>
      <DialogActions>
        <Button onClick={postForm} color="primary">
          Save
        </Button>
      </DialogActions>
    </Dialog>
  );
}
