from flask import Flask, request, jsonify
from flask_cors import CORS
import trimesh
import os

app = Flask(__name__)
CORS(app)  # Allow requests from frontend

UPLOAD_FOLDER = 'uploads'
os.makedirs(UPLOAD_FOLDER, exist_ok=True)

@app.route('/upload', methods=['POST'])
def upload():
    file = request.files['file']
    filename = file.filename
    filepath = os.path.join(UPLOAD_FOLDER, filename)
    file.save(filepath)

    # Load model using trimesh
    mesh = trimesh.load(filepath)

    if not isinstance(mesh, trimesh.Trimesh):
        return jsonify({'error': 'Not a valid mesh'}), 400

    volume = mesh.volume
    surface_area = mesh.area

    return jsonify({
        'filename': filename,
        'volume': volume,
        'surface_area': surface_area
    })

if __name__ == '__main__':
    app.run(debug=True)
