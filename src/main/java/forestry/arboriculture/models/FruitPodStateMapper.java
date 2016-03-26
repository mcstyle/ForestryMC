package forestry.arboriculture.models;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import forestry.api.arboriculture.IAlleleFruit;
import forestry.arboriculture.blocks.BlockFruitPod;
import forestry.core.config.Constants;
import forestry.core.render.ForestryStateMapper;

@SideOnly(Side.CLIENT)
public class FruitPodStateMapper extends ForestryStateMapper {

	@Override
	public Map<IBlockState, ModelResourceLocation> putStateModelLocations(Block block) {
		if (block instanceof BlockFruitPod) {
			BlockFruitPod blockFruitPod = (BlockFruitPod) block;
			IAlleleFruit fruit = blockFruitPod.getFruit();
			String modID = fruit.getModID();
			if (Constants.MOD_ID.equals(modID)) {
				String modelName = fruit.getModelName();
				String resourcePath = Constants.RESOURCE_ID + ":pods/" + modelName;
				for (IBlockState state : block.getBlockState().getValidStates()) {
					String propertyString = getPropertyString(state.getProperties());
					mapStateModelLocations.put(state, new ModelResourceLocation(resourcePath, propertyString));
				}
			}
		}
		return mapStateModelLocations;
	}
	
}